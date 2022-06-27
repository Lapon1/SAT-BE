package com.lapon.app.controller.register;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lapon.app.model.DownloadModel;
import com.lapon.app.model.RegisterModel;
import com.lapon.app.service.download.DownloadService;
import com.lapon.app.service.register.RegisterService;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	public RegisterService registerService;

	@Autowired
	public DownloadService downloadService;

	@PostMapping(value = "/insert")
	public Long RegisterOnCreate(HttpServletRequest request, HttpServletResponse response,
			@RequestBody RegisterModel form) throws Exception {
		Long resp = registerService.insert(form);

		return resp;
	}

	@GetMapping(value = "/{fname}")
	public List<RegisterModel> RegisterOnSearch(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("fname") String fname) throws Exception {
		List<RegisterModel> data = null;
		data = registerService.search(fname);

		return data;
	}

	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) throws Exception {
		InputStream fileInputStream = file.getInputStream();
		File fileToSave = new File("D:/" + file.getName() + ".txt");
		Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
		System.out.println(String.format("Data - %s", file));
		if (fileInputStream != null) {
			String text = "success";
			return text;
		} else {
			return null;
		}

	}

	@PostMapping("/download")
	public ResponseEntity<ByteArrayResource> download(HttpServletRequest request, HttpServletResponse response,
			@RequestBody DownloadModel downloadModel) throws Exception {
		DownloadModel pathFile = downloadService.findDownName(downloadModel.getId());
		File file = new File(pathFile.getPathname());
		Path path = Paths.get(file.getAbsolutePath());
		ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "test");
		
	    return ResponseEntity.ok().headers(header).
	            contentLength(file.length())
	            .contentType(MediaType.
	                  parseMediaType("application/octet-stream")).
	            body(resource);
		// InputStreamResource resource = new InputStreamResource(new
		// FileInputStream(file));
		// String text = "success";
		// return file;

	}

}
