package com.mrk.graphql.exceptions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorClassification;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class EmployeeNotFoundException extends RuntimeException implements GraphQLError{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public  EmployeeNotFoundException() {
		super("Employee not found");
	}
    private List<SourceLocation> locations;

	@Override
	public List<SourceLocation> getLocations() {
		return locations;
	}

	@Override
	public ErrorClassification getErrorType() {
		 return ErrorType.DataFetchingException;
	}
	
	@Override
    public Map<String, Object> getExtensions() {
        Map<String, Object> customAttributes = new LinkedHashMap<>();
        customAttributes.put("errorCode", "404");
        customAttributes.put("errorMessage", "Employee not found");
        return customAttributes;
    }
	
	@Override
    public Map<String, Object> toSpecification() {
        return GraphQLError.super.toSpecification();
    }
	@Override
	public String getMessage() {
		return "Employee not found";
	}	
}
