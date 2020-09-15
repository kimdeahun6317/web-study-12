package web_study_12.dto;

import java.util.Date;

public class Board {
	private int num;
	private String name;
	private String email;
	private String pass;
	private String title;
	private String content;
	private int readcount;
	private Date writedate;

	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Board(int num, String name, String email, String pass, String title, String content, int readcount,
			Date writedate) {
		super();
		this.num = num;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.title = title;
		this.content = content;
		this.readcount = readcount;
		this.writedate = writedate;
	}

	public Board(int num) {
		super();
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	@Override
	public String toString() {
		return "Board [num=" + num + ", name=" + name + ", email=" + email + ", pass=" + pass + ", title=" + title
				+ ", content=" + content + ", readcount=" + readcount + ", writedate=" + writedate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (num != other.num)
			return false;
		return true;
	}

}
