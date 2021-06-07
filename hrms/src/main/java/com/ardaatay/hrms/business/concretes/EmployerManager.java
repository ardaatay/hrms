package com.ardaatay.hrms.business.concretes;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardaatay.hrms.business.abstracts.EmployerService;
import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.ErrorResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.core.utilities.results.SuccessDataResult;
import com.ardaatay.hrms.core.utilities.results.SuccessResult;
import com.ardaatay.hrms.core.utilities.verification.EmailVerification;
import com.ardaatay.hrms.core.utilities.verification.Verification;
import com.ardaatay.hrms.dataAccess.abstracts.EmployerDao;
import com.ardaatay.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}

	@Override
	public Result add(Employer employer) {
		String domain = "";
		try {
			domain = getDomainName(employer.getWebSite());
		} catch (URISyntaxException e) {
			return new ErrorResult("Websitesi adresi geçerli değil");
		}

		if (!employer.getEmail().contains(domain)) {
			return new ErrorResult("Email adresiniz domain adresinizle aynı değil");
		}

		Employer checkEmployer = this.employerDao.getByEmail(employer.getEmail());
		if (checkEmployer != null) {
			return new ErrorResult("Bu mail adresi daha önce kayıt edilmiş");
		}

		this.employerDao.save(employer);
		return new SuccessResult("Çalışan eklendi.");
	}

	@Override
	public Result activate(String code) {
		Verification verification = new EmailVerification();
		if (verification.run(code)) {
			return new SuccessResult("Doğrulama başarılı");
		}

		return new ErrorResult("Doğrulama başarısız");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data Listelendi");
	}

	public static String getDomainName(String url) throws URISyntaxException {
		URI uri = new URI(url);
		String domain = uri.getHost();
		return domain.startsWith("www.") ? domain.substring(4) : domain;
	}

}
