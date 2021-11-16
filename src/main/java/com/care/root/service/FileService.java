package com.care.root.service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileService {
	public static final String IMAGE_REPO = "C:/spring/image_repo";
	public void fileProcess(MultipartHttpServletRequest mul);
	public void getShoesImage(Model model);
}
