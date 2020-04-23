package br.com.devdojo.springbootessentials.createdframework.error;

import javax.annotation.Generated;


/**
 * 
 * @author ferreira
 * @since 21/03/2020
 */
public class ErrorDetail {

	private String title;
	private int status;
	private String details;
	private long time;
	private String developerMessege;
	
	public ErrorDetail() {
		// TODO Auto-generated constructor stub
	}
	
	@Generated("SparkTools")
	private ErrorDetail(Builder builder) {
		this.title = builder.title;
		this.status = builder.status;
		this.details = builder.details;
		this.time = builder.time;
		this.developerMessege = builder.developerMessege;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getDeveloperMessege() {
		return developerMessege;
	}
	public void setDeveloperMessege(String developerMessege) {
		this.developerMessege = developerMessege;
	}
	/**
	 * used for generic error message
	 * Creates builder to build {@link ErrorDetail}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder newBuilder() {
		return new Builder();
	}
	/**
	 * Builder to build {@link ErrorDetail}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String title;
		private int status;
		private String details;
		private long time;
		private String developerMessege;

		private Builder() {
		}

		public Builder withTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder withStatus(int status) {
			this.status = status;
			return this;
		}

		public Builder withDetails(String details) {
			this.details = details;
			return this;
		}

		public Builder withTime(long time) {
			this.time = time;
			return this;
		}

		public Builder withDeveloperMessege(String developerMessege) {
			this.developerMessege = developerMessege;
			return this;
		}

		public ErrorDetail build() {
			return new ErrorDetail(this);
		}
	}
	
}
