package com.lapon.app.service.download;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lapon.app.model.DownloadModel;
import com.lapon.app.repository.DownloadRepository;

@Service
public class DownloadServiceImpl implements DownloadService {

	@Autowired
	DownloadRepository downloadRepository;
	private final Logger logger = LogManager.getLogger(DownloadServiceImpl.class);
	
	@Override
	@Transactional(readOnly = true)
	public DownloadModel findDownName(Long id) throws Exception {
		try {
			return downloadRepository.find(id);
		} catch (DataAccessException e) {
			logger.error(" error dataAcess", e);
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			logger.error(" error ", e);
			throw new RuntimeException(e.getMessage());
		}
	}

}
