package com.fedex.reject.resource;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fedex.reject.SwakInfo;
import com.fedex.reject.SwakRepository;
import com.fedex.reject.service.RejectRepairService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/reject/repair")
@Api(value = "reject repair endpoint")
public class RejectRepairResource {

	
	Logger logger=LoggerFactory.getLogger(RejectRepairResource.class);
	@Autowired
	SwakRepository swakRepository;
	
	@Autowired
	RejectRepairService rejectRepairService;
	
	@GetMapping
	public List<SwakInfo> getSwakInfo() {
		
		
		return (List<SwakInfo>) swakRepository. findAll();

		/*
		 * return Arrays.asList(
		 * 
		 * new SwakInfo(483220, 30, 3, 54, "shipmentRoute Indo-US root", 1595000727,
		 * 1595000727, true, true, "shipmentDetails", 1595000727, "smartPost location",
		 * "itemDescription", 1, 20, "billTo", "campushelpdesk@syntelinc.com",
		 * "Atos Syntel Inc.525 E. Big Beaver Road Suite 300 Troy, MI 48083 United States Tel: +1 (248) 619-2800"
		 * , 1234567891, 987456321, 1234567890));
		 */

	}

	@ApiOperation(value = "Returns SwakInfo")
	@PostMapping("/")
	public SwakInfo postSwakInfo(@RequestBody  SwakInfo swakInfo) throws JsonProcessingException, UnsupportedEncodingException {
		
		rejectRepairService.sendMessage(swakInfo);
		
		swakRepository.deleteAll();
		logger.info("msg del and send");	
		return swakInfo;
		
		//return swakInfo;
	}

}
