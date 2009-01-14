package org.gbif.provider.tapir;

import org.gbif.provider.model.ExtensionProperty;

public abstract class ComparisonOperator extends LogicalOperator implements BooleanOperator {
	private ExtensionProperty property;
	private String value;
	
	
	public ExtensionProperty getProperty() {
		return property;
	}
	public void setProperty(ExtensionProperty property) {
		log.debug("Setting property to: " + property.getQualName());
		property.setName(property.getQualName());
		this.property = property;
	}
	public void setProperty(String propertyAsString) {
		setProperty(new ExtensionProperty(propertyAsString));
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	protected abstract String getOperatorSymbol();

	public String toString(){
		return String.format("%s %s '%s'", property.getName(), getOperatorSymbol(), value);
	}
}
