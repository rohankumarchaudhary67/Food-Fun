package com.foodnfun.backend.controller;
import com.foodnfun.backend.dto.VendorDTO;

//import com.foodnfun.backend.entity.Vendor;
import com.foodnfun.backend.service.VendorService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import com.foodnfun.backend.response.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

	private final VendorService vendorService;
	
	public VendorController(VendorService vendorService) {
		this.vendorService=vendorService;
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse<VendorDTO>> createvendor(@Valid @RequestBody VendorDTO vendorDTO) {
		VendorDTO savedVendor = vendorService.createVendor(vendorDTO);

	    return ResponseEntity.status(HttpStatus.CREATED)
	            .body(new ApiResponse<>(
	                    true,
	                    "Vendor created successfully",
	                    savedVendor
	            ));
	}
	
	@GetMapping
	public ResponseEntity<ApiResponse<List<VendorDTO>>> getAllVendors() {

        List<VendorDTO> vendors = vendorService.getAllVendors();

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Vendors fetched successfully",
                        vendors
                ));
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<VendorDTO>> getVendorById(
            @PathVariable Long id) {

        VendorDTO vendor = vendorService.getVendorById(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Vendor fetched successfully",
                        vendor
                ));
    }
}
