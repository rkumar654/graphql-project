package com.mrk.graphql.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.GraphQLException;
import graphql.GraphqlErrorBuilder;
import graphql.kickstart.execution.error.GraphQLErrorHandler;

@Component
public class GraphQLErrorHandlerImpl implements GraphQLErrorHandler{

	@Override
	public List<GraphQLError> processErrors(List<GraphQLError> graphQLErrors) {
        return graphQLErrors.stream().map(this::handleGraphQLError).collect(Collectors.toList());
	}
	private GraphQLError handleGraphQLError(GraphQLError error) {
        if (error instanceof GraphQLException) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "GraphQLException as GraphQLError...", (GraphQLException) error);
        } else if (error instanceof EmployeeNotFoundException){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ValidationError: " + error.getMessage());
        } else if (error instanceof ExceptionWhileDataFetching){
        	return GraphqlErrorBuilder.newError().message((String)error.getExtensions().get("errorMessage"))
        			                             .errorType(error.getErrorType())
        			                             .extensions(error.getExtensions())
        			                             .build();
        }
        System.out.println("Yet another GraphQLError..."+error);
		return error;
    }
}
