package liquibase.statement.core;

import liquibase.statement.AbstractSqlStatement;

public class SetNullableStatement extends AbstractSqlStatement {
    private final String columnName;
    private final String columnDataType;
    private final boolean nullable;
    private String constraintName;
    private boolean validate = true;
    private DatabaseTableIdentifier databaseTableIdentifier = new DatabaseTableIdentifier(null, null, null);

    public SetNullableStatement(String catalogName, String schemaName, String tableName, String columnName, String columnDataType, boolean nullable) {
        this.databaseTableIdentifier.setCatalogName(catalogName);
        this.databaseTableIdentifier.setSchemaName(schemaName);
        this.databaseTableIdentifier.setTableName(tableName);
        this.columnName = columnName;
        this.columnDataType = columnDataType;
        this.nullable = nullable;
    }

    public SetNullableStatement(String catalogName, String schemaName, String tableName, String columnName, String columnDataType, boolean nullable, String constraintName) {
        this(catalogName, schemaName, tableName, columnName, columnDataType, nullable);
        this.constraintName = constraintName;
    }

    public SetNullableStatement(String catalogName, String schemaName, String tableName, String columnName,
                                String columnDataType, boolean nullable, String constraintName, Boolean validate) {
        this(catalogName, schemaName, tableName, columnName, columnDataType, nullable);
        this.constraintName = constraintName;
        if (validate!=null) {
            this.validate = validate;
        }
    }

    public String getCatalogName() {
        return databaseTableIdentifier.getCatalogName();
    }

    public String getSchemaName() {
        return databaseTableIdentifier.getSchemaName();
    }

    public String getTableName() {
        return databaseTableIdentifier.getTableName();
    }

    public String getColumnName() {
        return columnName;
    }

    public String getColumnDataType() {
        return columnDataType;
    }

    public boolean isNullable() {
        return nullable;
    }

    public String getConstraintName() {
        return constraintName;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }
}
