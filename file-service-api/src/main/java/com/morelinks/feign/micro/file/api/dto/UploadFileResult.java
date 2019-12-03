package com.morelinks.feign.micro.file.api.dto;

/**
 * 上传文件返回结果
 */
public class UploadFileResult {
	/**
	 * 文件名 包含后缀
	 */
	private String fileName;
	/**
	 * 文件访问的url
	 */
	private String fileUrl;
	/**
	 * 文件的相对路径
	 */
	private String filePath;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}

