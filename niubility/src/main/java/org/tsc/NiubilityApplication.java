package org.tsc;

import io.awspring.cloud.dynamodb.DynamoDbOperations;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tsc.model.Recipient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.ListTablesRequest;
import software.amazon.awssdk.services.dynamodb.model.ListTablesResponse;

import java.util.List;

@SpringBootApplication
public class NiubilityApplication {

	Region region = Region.US_EAST_1;

	DynamoDbClient ddb = DynamoDbClient.builder()
			// .credentialsProvider(credentialsProvider)
			.region(region)
			.build();

	public static void main(String[] args) {
		SpringApplication.run(NiubilityApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(DynamoDbOperations dynamoDbOperations,
										DynamoDbEnhancedClient dynamoDbEnhancedClient) {
		return args -> {
			ListTablesResponse response = null;
			ListTablesRequest request = ListTablesRequest.builder().build();
			response = ddb.listTables(request);
			List<String> tableNames = response.tableNames();

			if (!tableNames.contains("Recipient")) {
				dynamoDbEnhancedClient.table("Recipient", TableSchema.fromBean(Recipient.class)).createTable();
			}
		};
	}

}
