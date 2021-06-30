package com.ardaatay.hrms.business.concretes;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardaatay.hrms.business.abstracts.CustomerService;
import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.ErrorResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.core.utilities.results.SuccessDataResult;
import com.ardaatay.hrms.core.utilities.results.SuccessResult;
import com.ardaatay.hrms.core.utilities.verification.EmailVerification;
import com.ardaatay.hrms.core.utilities.verification.Verification;
import com.ardaatay.hrms.dataAccess.abstracts.CustomerDao;
import com.ardaatay.hrms.entities.concretes.Customer;
import com.ardaatay.hrms.entities.dtos.CustomerDto;

@Service
public class CustomerManager implements CustomerService {

	private CustomerDao customerDao;
	private ModelMapper modelMapper;

	@Autowired
	public CustomerManager(CustomerDao customerDao, ModelMapper modelMapper) {
		this.customerDao = customerDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(CustomerDto customerDto) {

		Customer customer = convertToEntity(customerDto);
		customer.setPasswordHash(customerDto.getPassword());
		customer.setPasswordSalt("ardaatay");
		customer.setActivate(false);

		String domain = "";
		try {
			domain = getDomainName(customer.getWebSite());
		} catch (URISyntaxException e) {
			return new ErrorResult("Websitesi adresi geçerli değil");
		}

		if (!customer.getEmail().contains(domain)) {
			return new ErrorResult("Email adresiniz domain adresinizle aynı değil");
		}

		Customer checkEmployer = this.customerDao.getByEmail(customer.getEmail());
		if (checkEmployer != null) {
			return new ErrorResult("Bu mail adresi daha önce kayıt edilmiş");
		}

		this.customerDao.save(customer);
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
	public DataResult<List<Customer>> getAll() {
		return new SuccessDataResult<List<Customer>>(this.customerDao.findAll(), "Data Listelendi");
	}

	public static String getDomainName(String url) throws URISyntaxException {
		URI uri = new URI(url);
		String domain = uri.toString();
		return domain.startsWith("www.") ? domain.substring(4) : domain;
	}

	private Customer convertToEntity(CustomerDto customerDto) {
		Customer customer = modelMapper.map(customerDto, Customer.class);
		return customer;
	}

}
