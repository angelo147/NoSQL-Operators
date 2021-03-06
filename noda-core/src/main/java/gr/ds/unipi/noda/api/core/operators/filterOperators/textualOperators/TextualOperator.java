package gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

import java.util.Arrays;

public abstract class TextualOperator<T> implements FilterOperator<T> {

    private final String fieldName;
    private final String[] keywords;

    protected TextualOperator(String fieldName, String[] keywords) {
        this.fieldName = fieldName;
        this.keywords = keywords;
    }

    public String[] getKeywords() {
        return keywords.clone();
    }

    public String getFieldName() {
        return fieldName;
    }

    public static BaseTextualOperatorFactory textualOperator;


    public static String[] twoKeywordsAtLeastToArray(String keyword1, String keyword2, String... keywords) {
        String[] keywordsArray;

        if (keywords.length == 0) {
            keywordsArray = new String[]{keyword1, keyword2};
        } else {
            keywordsArray = new String[keywords.length + 2];
            keywordsArray[0] = keyword1;
            keywordsArray[1] = keyword2;

            int i = 2;
            for (String kwrds : keywords) {
                keywordsArray[i++] = kwrds;
            }
        }
        return keywordsArray;
    }

    public static String[] oneKeywordsAtLeastToArray(String keyword, String... keywords) {
        String[] keywordsArray;

        if (keywords.length == 0) {
            keywordsArray = new String[]{keyword};
        } else {
            keywordsArray = new String[keywords.length + 1];
            keywordsArray[0] = keyword;

            int i = 1;
            for (String kwrds : keywords) {
                keywordsArray[i++] = kwrds;
            }
        }
        return keywordsArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextualOperator<?> that = (TextualOperator<?>) o;

        if (!fieldName.equals(that.fieldName)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(keywords, that.keywords);
    }

    @Override
    public int hashCode() {
        int result = fieldName.hashCode();
        result = 31 * result + Arrays.hashCode(keywords);
        result = 31 * result + getClass().hashCode();
        return result;
    }
}
