package com.ssafy.edu.vue.dto;


public class BoardDto {
	private int no;
	private String title;
	private String writer;
	private String content;
	private String write_date;
	private int read_count;
	public BoardDto() {}
	
	public BoardDto(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public BoardDto(String title, String writer, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	public BoardDto(int no, String title, String writer, String content, String write_date) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.write_date = write_date;
	}

	public BoardDto(int no, String title, String writer, String content, String write_date, int read_count) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.write_date = write_date;
		this.read_count = read_count;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
	@Override
	public String toString() {
		return "BoardDTO [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", write_date=" + write_date + ", read_count=" + read_count + "]";
	}	
}
