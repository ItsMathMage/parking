package com.utm.mapper;

import com.utm.dto.ReserveDTO;
import com.utm.entity.Client;
import com.utm.entity.Reserve;
import org.springframework.stereotype.Component;

@Component
public class ReserveToReserveDTOMapper {
    public Reserve toEntity(final ReserveDTO reserveDTO, final Client client) {
        if(client == null) {

            //todo add custom exception throwing

        }

        final Reserve reserve = new Reserve();

        reserve.setId(reserveDTO.getId());
        reserve.setReserveDate(reserveDTO.getReserveDate());
        reserve.setClient(client);

        return reserve;
    }

    public ReserveDTO toDTO(final Reserve reserve) {
        final ReserveDTO reserveDTO = new ReserveDTO();

        reserveDTO.setId(reserve.getId());
        reserveDTO.setReserveDate(reserve.getReserveDate());

        return reserveDTO;
    }
}
