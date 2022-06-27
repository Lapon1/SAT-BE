package com.lapon.app.repository;

import com.lapon.app.model.DownloadModel;

public interface DownloadRepository {

	public DownloadModel find(Long id) throws Exception;

}
