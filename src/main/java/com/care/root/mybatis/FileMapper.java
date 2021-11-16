package com.care.root.mybatis;

import java.util.List;

import com.care.root.dto.ShoesDTO;

public interface FileMapper {
	public void saveData(ShoesDTO dto);
	public List<ShoesDTO> getShoesImage();
}








