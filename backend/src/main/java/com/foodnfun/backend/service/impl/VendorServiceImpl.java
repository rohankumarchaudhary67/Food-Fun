package com.foodnfun.backend.service.impl;

import com.foodnfun.backend.dto.VendorDTO;
import com.foodnfun.backend.entity.Vendor;
import com.foodnfun.backend.exception.ResourceNotFoundException;
import com.foodnfun.backend.repository.VendorRepository;
import com.foodnfun.backend.service.VendorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VendorServiceImpl implements VendorService{

	private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    // ---------- CREATE ----------
    @Override
    public VendorDTO createVendor(VendorDTO vendorDTO) {
        Vendor vendor = mapToEntity(vendorDTO);
        Vendor saved = vendorRepository.save(vendor);
        return mapToDTO(saved);
    }
    
    // ---------- READ ALL ----------
    @Override
    public List<VendorDTO> getAllVendors() {
        return vendorRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // ---------- READ BY ID ----------
    @Override
    public VendorDTO getVendorById(Long id) {
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found with id: " + id));
        return mapToDTO(vendor);
    }
    
    // ---------- MAPPING ----------
    private Vendor mapToEntity(VendorDTO dto) {
        Vendor vendor = new Vendor();
        vendor.setName(dto.getName());
        vendor.setEmail(dto.getEmail());
        vendor.setPhone(dto.getPhone());
        return vendor;
    }

    private VendorDTO mapToDTO(Vendor vendor) {
        VendorDTO dto = new VendorDTO();
        dto.setId(vendor.getId());
        dto.setName(vendor.getName());
        dto.setEmail(vendor.getEmail());
        dto.setPhone(vendor.getPhone());
        return dto;
    }
}
