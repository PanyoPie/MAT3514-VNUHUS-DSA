package vn.io.tunaa.dsa.exam_2526_1st_midterm_2.ex2__stack__array_implementation_and_boolean_expression;

import java.util.Stack;

public class BooleanExpressionCalculator {

    /**
     * Tính giá trị logic (true/false) của biểu thức boolean đầu vào.
     *
     * @param expression chuỗi biểu thức logic cần tính toán.
     *             Các phần tử phải được phân tách bằng khoảng trắng và có ngoặc đầy đủ.
     *             Ví dụ: "( ! ( ( true && false ) || true ) )".
     *
     * @return kết quả boolean sau khi tính toán biểu thức.
     */
    public boolean computeBooleanExpression(String expression) {
        String[] tokens = expression.trim().split("\\s+");

        Stack<String> operators = new Stack<>();
        Stack<Boolean> booleans = new Stack<>();
        booleans.push(true);

        for (String token : tokens) {
            if (token.equals("||") || token.equals("&&") || token.equals("!")) {
                operators.push(token);
            } else if (token.equals("true") || token.equals("false")) {
                booleans.push(Boolean.parseBoolean(token));
            } else if (token.equals(")")) {
                String operator;
                boolean boolean1, boolean2;

                if (operators.isEmpty()) {
                    break;
                }

                operator = operators.pop();
                if (operator.equals("||") || operator.equals("&&")) {
                    boolean1 = booleans.pop();
                    boolean2 = booleans.pop();

                    if (operator.equals("||")) {	 	  	 		      	     		   	       	 	
                        booleans.push(boolean1 || boolean2);
                    }

                    if (operator.equals("&&")) {
                        booleans.push(boolean1 && boolean2);
                    }
                } else if (operator.equals("!")) {
                    boolean1 = booleans.pop();
                    booleans.push(!boolean1);
                }
            }
        }

        return booleans.pop();
    }
}