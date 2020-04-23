package br.com.devdojo.springbootessentials.createdframework.error;

import javax.annotation.Generated;

/**
 * 
 * @author ferreira
 * @since 29/03/2020
 */
public class ValidationErrorDetails extends ErrorDetail{
	
	private String field;
	private String fieldMessage;
	
	@Generated("SparkTools")
	private ValidationErrorDetails(Builder builder) {
		this.field = builder.field;
		this.fieldMessage = builder.fieldMessage;
		setTitle(builder.title);
		setStatus(builder.status);
		setDetails(builder.details);
		setTime(builder.time);
		setDeveloperMessege(builder.developerMessege);
	}
	/**
	 * Creates builder to build {@link ValidationErrorDetails}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}
	/**
	 * Builder to build {@link ValidationErrorDetails}.
	 */
	@Generated("SparkTools")
	public static final class Builder {

		private String title;
		private int status;
		private String details;
		private long time;
		private String developerMessege;
		private String field;
		private String fieldMessage;

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

		public Builder withField(String field) {
			this.field = field;
			return this;
		}

		public Builder withFieldMessage(String fieldMessage) {
			this.fieldMessage = fieldMessage;
			return this;
		}

		public ValidationErrorDetails build() {
			return new ValidationErrorDetails(this);
		}
		
	}
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getFieldMessage() {
		return fieldMessage;
	}
	public void setFieldMessage(String fieldMessage) {
		this.fieldMessage = fieldMessage;
	}
	
}