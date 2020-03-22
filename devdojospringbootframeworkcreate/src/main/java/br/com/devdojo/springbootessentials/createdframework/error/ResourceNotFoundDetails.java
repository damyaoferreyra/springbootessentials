package br.com.devdojo.springbootessentials.createdframework.error;

import javax.annotation.Generated;


public class ResourceNotFoundDetails {

	private String title;
	private int status;
	private String details;
	private long time;
	private String developerMessege;


	@Generated("SparkTools")
	private ResourceNotFoundDetails(Builder builder) {
		this.title = builder.title;
		this.status = builder.status;
		this.details = builder.details;
		this.time = builder.time;
		this.developerMessege = builder.developerMessege;
	}
	
	public String getTitle() {
		return title;
	}

	public int getStatus() {
		return status;
	}

	public String getDetails() {
		return details;
	}

	public long getTime() {
		return time;
	}

	public String getDeveloperMessege() {
		return developerMessege;
	}
	

	@SuppressWarnings("unused")
	private ResourceNotFoundDetails() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * Creates builder to build {@link ResourceNotFoundDetails}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}


	/**
	 * Builder to build {@link ResourceNotFoundDetails}.
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

		public ResourceNotFoundDetails build() {
			return new ResourceNotFoundDetails(this);
		}
	}
	
	
}
