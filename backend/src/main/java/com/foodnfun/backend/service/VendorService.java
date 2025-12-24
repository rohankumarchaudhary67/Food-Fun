package com.foodnfun.backend.service;
import com.foodnfun.backend.dto.VendorDTO;

//import com.foodnfun.backend.entity.Vendor;
import java.util.List;

public interface VendorService {

	 VendorDTO createVendor(VendorDTO vendorDTO);

	    List<VendorDTO> getAllVendors();
	    
	   VendorDTO getVendorById(Long id); 
}
