package testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.MethodCallExpr;

public class AutoGrader {

	// Test for string manipulation with numbers
	public boolean testStringWithNumbers(String filePath) throws IOException {
		System.out.println("Starting testStringWithNumbers with file: " + filePath);

		// Load participant's file
		File participantFile = new File(filePath); // Path to participant's file
		if (!participantFile.exists()) {
			System.out.println("File does not exist at path: " + filePath);
			return false;
		}

		// Parse the file using JavaParser
		FileInputStream fileInputStream = new FileInputStream(participantFile);
		JavaParser javaParser = new JavaParser();
		CompilationUnit cu;
		try {
			cu = javaParser.parse(fileInputStream).getResult()
					.orElseThrow(() -> new IOException("Failed to parse the Java file"));
		} catch (IOException e) {
			System.out.println("Error parsing the file: " + e.getMessage());
			throw e;
		}

		System.out.println("Parsed the Java file successfully.");

		// Flag to check for string manipulation with numbers
		boolean hasNumberOperations = false;

		// 1. Checking if any number-related methods (e.g., valueOf, parseInt, matches)
		// are used
		System.out.println("------ Checking String with Numbers Operations ------");
		for (MethodCallExpr method : cu.findAll(MethodCallExpr.class)) {
			String methodName = method.getNameAsString();
			if (methodName.equals("valueOf") || methodName.equals("parseInt") || methodName.equals("matches")) {
				hasNumberOperations = true;
				System.out.println("✓ Found string manipulation with number method: " + methodName);
			}
		}

		// Output the result for string manipulation with numbers methods
		if (hasNumberOperations) {
			System.out.println("✓ String manipulation with numbers methods are present.");
		} else {
			System.out.println("✘ Missing string manipulation with numbers methods.");
		}

		// Test result
		System.out.println("Test result: " + hasNumberOperations);
		return hasNumberOperations;
	}
}
