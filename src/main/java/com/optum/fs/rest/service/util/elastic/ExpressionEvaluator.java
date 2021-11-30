//package com.optum.fs.rest.service.util.elastic;
//
//
//import org.apache.lucene.search.join.ScoreMode;
//import org.elasticsearch.action.search.SearchRequest;
//import org.elasticsearch.index.query.BoolQueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.index.query.WildcardQueryBuilder;
//import org.elasticsearch.search.builder.SearchSourceBuilder;
//
//import java.util.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class ExpressionEvaluator {
//    private static final String DOT_OPERATOR = ".";
//    private static final String ES_INDEX = "users";
//    private static final char LEFT_PARENTHESIS = '(';
//    private static final char RIGHT_PARENTHESIS = ')';
//    private static final char AND_OPERATOR = '+';
//    private static final char NOT_OPERATOR = '-';
//    private static final char OR_OPERATOR = '|';
//    private static final String NULL_ASSIGNMENT = "null";
//    private static final String AND = "AND";
//    private static final String NOT = "NOT";
//    private static final String OR = "OR";
//    private static final String EQUAL = "=";
//    private static final String NOT_EQUAL = "!=";
//    private static final String GT = ">";
//    private static final String GTE = ">=";
//    private static final String LT = "<";
//    private static final String LTE = "<=";
//    private static final String LOGICAL_OR = "OR";
//    private static final String LOGICAL_AND = "AND";
//    private static final String WILDCARD_PATTERN = "*";
//    private static final String INVALID_OPERATOR = "INVALID";
//    private TreeMap<Character, Integer> precedence;
//    private Set<Character> allowedOperatorsForQuery;
//    private Logger logger = Logger.getLogger(this.getClass().getName());
//
//    public ExpressionEvaluator() {
//        precedence = new TreeMap<>();
//        precedence.put(LEFT_PARENTHESIS, 0);   // for convenience with algorithm
//        precedence.put(RIGHT_PARENTHESIS, 0);
//        precedence.put(AND_OPERATOR, 1);
//        precedence.put(NOT_OPERATOR, 1);
//        precedence.put(OR_OPERATOR, 1);
//        allowedOperatorsForQuery = new HashSet<>();
//        allowedOperatorsForQuery.add('=');
//        allowedOperatorsForQuery.add('!');
//        allowedOperatorsForQuery.add('>');
//        allowedOperatorsForQuery.add('<');
//
//
//    }
//
//    public static void main(String[] args) {
//        String testExpression = "(part_key = elbow)";
//        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
//        expressionEvaluator.executeQuery(testExpression);
//
//    }
//
//    private void executeQuery(String testExpression) {
//        ExpressionTreeNode root = buildTree(testExpression);
//        SearchRequest searchRequest = new SearchRequest(ES_INDEX);
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = buildQuery(root);
//        sourceBuilder.query(boolQueryBuilder);
//        searchRequest.source(sourceBuilder);
//        SearchApi searchApi = new SearchApi();
//      //  searchApi.resultListResponse(searchRequest);
//
//    }
//
//    private BoolQueryBuilder buildQuery(ExpressionTreeNode root) {
//        if (isLeaf(root)) {
//          //  return getBoolQueryBuilder(root);
//
//        } else {
//            BoolQueryBuilder leftBoolQueryBuilder = buildQuery(root.left);
//            BoolQueryBuilder rightBoolQueryBuilder = buildQuery(root.right);
//            String logicalOperator = root.expression.op;
//            BoolQueryBuilder nodeBoolQueryBuilder = QueryBuilders.boolQuery();
//            if (logicalOperator != null) {
//                if (logicalOperator.equals(LOGICAL_OR)) {
//                    nodeBoolQueryBuilder.should(leftBoolQueryBuilder).should(rightBoolQueryBuilder);
//                } else if (logicalOperator.equals(LOGICAL_AND)) {
//                    nodeBoolQueryBuilder.must(rightBoolQueryBuilder).must(leftBoolQueryBuilder);
//                } else {
//                    nodeBoolQueryBuilder = null;
//                }
//            }
//            return nodeBoolQueryBuilder;
//        }
//    }
//
////    private BoolQueryBuilder getBoolQueryBuilder(ExpressionTreeNode root) {
////        ConditionExpression conditionBlock = root.expression;
////        String op = conditionBlock.op;
////        String report = "report";
////        String key = report.concat(DOT_OPERATOR).concat(conditionBlock.key);
////        String value = conditionBlock.value;
////        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
////        switch (op) {
////            case EQUAL:
////                if (value.contains(WILDCARD_PATTERN)) {
////                    boolQueryBuilder.should(QueryBuilders.nestedQuery(report, new WildcardQueryBuilder(key, value), ScoreMode.None));
////                } else {
////                    boolQueryBuilder.should(QueryBuilders.nestedQuery(report, new MatchPhrasePrefixQueryBuilder(key, value), ScoreMode.None));
////                }
////                break;
////            case NOT_EQUAL:
////                if (value.contains(WILDCARD_PATTERN)) {
////                    boolQueryBuilder.mustNot(QueryBuilders.nestedQuery(report, new WildcardQueryBuilder(key, value), ScoreMode.None));
////                } else {
////                    boolQueryBuilder.mustNot(QueryBuilders.nestedQuery(report, new MatchPhrasePrefixQueryBuilder(key, value), ScoreMode.None));
////                }
////                break;
////            case GT:
////                boolQueryBuilder.should(QueryBuilders.nestedQuery(report, QueryBuilders.rangeQuery(key).gt(value), ScoreMode.None));
////                break;
////            case GTE:
////                boolQueryBuilder.should(QueryBuilders.nestedQuery(report, QueryBuilders.rangeQuery(key).gte(value), ScoreMode.None));
////                break;
////            case LT:
////                boolQueryBuilder.should(QueryBuilders.nestedQuery(report, QueryBuilders.rangeQuery(key).lt(value), ScoreMode.None));
////                break;
////            case LTE:
////                boolQueryBuilder.should(QueryBuilders.nestedQuery(report, QueryBuilders.rangeQuery(key).lte(value), ScoreMode.None));
////                break;
////            default:
////                boolQueryBuilder = null;
////                break;
////
////        }
////        return boolQueryBuilder;
////    }
//
//    private boolean isLeaf(ExpressionTreeNode expressionTreeNode) {
//        return (expressionTreeNode.left == null && expressionTreeNode.right == null);
//    }
//
//    private ExpressionTreeNode buildTree(String expression) {
//        Deque<Character> operatorStack = new LinkedList<>();
//        Deque<ExpressionTreeNode> queryExpressionNodeStack = new LinkedList<>();
//        StringBuilder condition = new StringBuilder();
//        int i = 0;
//        StringBuilder op = new StringBuilder();
//        try {
//            while (i < expression.length()) {
//                char ch = expression.charAt(i);
//
//                if (ch == LEFT_PARENTHESIS) {
//                    if ((operatorStack.isEmpty() || (precedence.get(ch) > precedence.get(operatorStack.peek())))) {
//                        operatorStack.push(ch);
//                    }
//                    i++;
//                } else if (isValidCharacter(ch)) {
//                        condition.append(ch);
//                        if (isValidOperator(ch))
//                            op.append(ch);
//                    i++;
//                } else if (ch == OR_OPERATOR || ch == AND_OPERATOR || ch == NOT_OPERATOR) {
//                    if (condition.toString().trim().length() >= 1) {
//                        ConditionExpression conditionBlock = getObject(condition.toString().trim(), op);
//                        ExpressionTreeNode node = new ExpressionTreeNode(conditionBlock);
//                        queryExpressionNodeStack.push(node);
//                    }
//                    operatorStack.push(ch);
//                    i++;
//                    condition.delete(0, condition.length());
//                    op.delete(0, op.length());
//                } else if (ch == RIGHT_PARENTHESIS) {
//                    processConditionExpression(operatorStack, queryExpressionNodeStack, condition, op);
//                    if (!operatorStack.isEmpty())
//                        operatorStack.pop();
//                    i++;
//                } else {
//                    throw new Exception("Invalid Character");
//                }
//            }
//        } catch (Exception ex) {
//            logger.log(Level.INFO, "Invalid character");
//        }
//
//
//        while (!operatorStack.isEmpty())
//
//        {
//            char pop;
//            if (!operatorStack.isEmpty()) {
//                pop = operatorStack.pop();
//            } else {
//                break;
//            }
//            String operator = getOperator(pop);
//            ExpressionTreeNode leftChild = queryExpressionNodeStack.pop();
//            ExpressionTreeNode rightChild = queryExpressionNodeStack.pop();
//            ExpressionTreeNode operatorRoot = new ExpressionTreeNode(new ConditionExpression(NULL_ASSIGNMENT, operator, NULL_ASSIGNMENT));
//            operatorRoot.left = leftChild;
//            operatorRoot.right = rightChild;
//            queryExpressionNodeStack.push(operatorRoot);
//        }
//
//
//        return queryExpressionNodeStack.pop();
//
//
//    }
//
//    private void processConditionExpression(Deque<Character> operatorStack, Deque<ExpressionTreeNode> queryExpressionNodeStack, StringBuilder condition, StringBuilder op) {
//        ConditionExpression conditionBlock;
//        if (condition.toString().trim().length() >= 1) {
//            conditionBlock = getObject(condition.toString().trim(), op);
//            queryExpressionNodeStack.push(new ExpressionTreeNode(conditionBlock));
//        }
//
//        condition.delete(0, condition.length());
//        op.delete(0, op.length());
//
//
//        while (!operatorStack.isEmpty() && operatorStack.peek() != LEFT_PARENTHESIS) {
//            char pop = operatorStack.pop();
//            String operator = getOperator(pop);
//            ExpressionTreeNode leftChild = queryExpressionNodeStack.pop();
//            ExpressionTreeNode rightChild = queryExpressionNodeStack.pop();
//            ExpressionTreeNode operatorRoot = new ExpressionTreeNode(new ConditionExpression(NULL_ASSIGNMENT, operator, NULL_ASSIGNMENT));
//            operatorRoot.left = leftChild;
//            operatorRoot.right = rightChild;
//            queryExpressionNodeStack.push(operatorRoot);
//        }
//    }
//
//    private boolean isValidCharacter(char ch) {
//        boolean isValid;
//        switch (ch) {
//            case OR_OPERATOR:
//                isValid = false;
//                break;
//            case AND_OPERATOR:
//                isValid = false;
//                break;
//            case NOT_OPERATOR:
//                isValid = false;
//                break;
//            case RIGHT_PARENTHESIS:
//                isValid = false;
//                break;
//            default:
//                isValid = true;
//                break;
//
//        }
//        return isValid;
//    }
//
//    private boolean isValidOperator(char ch) {
//        return allowedOperatorsForQuery.contains(ch);
//    }
//
//    private String getOperator(char pop) {
//        String cond;
//
//        switch (pop) {
//            case AND_OPERATOR:
//                cond = AND;
//                break;
//            case NOT_OPERATOR:
//                cond = NOT;
//                break;
//            case OR_OPERATOR:
//                cond = OR;
//                break;
//            default:
//                cond = INVALID_OPERATOR;
//                break;
//        }
//        return cond;
//    }
//
//    private ConditionExpression getObject(String expression, StringBuilder op) {
//        ConditionExpression conditionExpression;
//        int opLength = op.toString().trim().length();
//        int opStartIndex = expression.indexOf(op.toString());
//        int opEndIndex = opStartIndex + opLength;
//        String key = expression.substring(0, opStartIndex).trim();
//        String value = expression.substring(opEndIndex).trim();
//        conditionExpression = new ConditionExpression(key, op.toString().trim(), value);
//        return conditionExpression;
//
//
//    }
//
//}
//
//class ExpressionTreeNode {
//    ConditionExpression expression;
//    ExpressionTreeNode left;
//    ExpressionTreeNode right;
//
//    ExpressionTreeNode(ConditionExpression expression) {
//        this.expression = expression;
//        this.left = null;
//        this.right = null;
//    }
//
//}
