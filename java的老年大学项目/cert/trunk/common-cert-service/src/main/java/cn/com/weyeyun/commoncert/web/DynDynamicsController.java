package cn.com.weyeyun.commoncert.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.weyeyun.commoncert.core.CertManager;
import cn.com.weyeyun.commoncert.dto.CertDTO;

@RestController
public class DynDynamicsController {
    @Autowired
    private CertManager certmanager;
    
	@RequestMapping(value="/")//是springmvc中的注解
    String home(){
        return "helloworld";
    }
	
	@RequestMapping("/hello")
	public String queryPageList() {
		System.out.println("hello workd");
		return "hello world";
	}
	
	@RequestMapping("/save")
	public String savecert() {
		CertDTO certDTO = new CertDTO ();
		certDTO.setCertType(1);
		certDTO.setName("dddd");
		certDTO.setNumCode(1);
		certDTO.setCode("123");
		certDTO.setNumCode(1);
		certDTO.setSerialNum(1);
		certDTO.setTenantId(1l);
		certmanager.save(certDTO);
		System.out.println("hello workd");
		return "hello world";
	}
}
