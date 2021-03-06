package br.com.devdojo.springbootessentials.createdframework.error;

import javax.annotation.Generated;

public class ResourceNotFoundDetails extends ErrorDetail{

	@Generated("SparkTools")
	protected ResourceNotFoundDetails(Builder builder) {
		setTitle(builder.title);
		setStatus(builder.status);
		setDetails(builder.details);
		setTime(builder.time);
		setDeveloperMessege(builder.developerMessege);
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
