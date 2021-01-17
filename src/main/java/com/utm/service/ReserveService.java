package com.utm.service;

import com.utm.dto.ReserveDTO;

import java.util.List;

public interface ReserveService {
    ReserveDTO getReserveById(Long id);
    List<ReserveDTO> getAllReserves();
    ReserveDTO createReserve(ReserveDTO reserveDTO);
    ReserveDTO updateReserve(ReserveDTO reserveDTO);
    void deleteReserveById(Long id);
}
