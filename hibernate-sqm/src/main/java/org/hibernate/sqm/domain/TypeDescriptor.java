/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: Apache License, Version 2.0
 * See the LICENSE file in the root directory or visit http://www.apache.org/licenses/LICENSE-2.0
 */
package org.hibernate.sqm.domain;

/**
 * Basic descriptor for a type in the user's domain model.
 *
 * @author Steve Ebersole
 */
public interface TypeDescriptor {
	/**
	 * The unique name for this type.
	 *
	 * @return The type name.
	 */
	String getTypeName();

	/**
	 * Look for a descriptor of the named attribute within this type.
	 *
	 * @param attributeName The name of the attribute for which to get the descriptor.
	 *
	 * @return The attribute's descriptor, or {@code null} if this type does not contain any
	 * such named attribute.
	 */
	AttributeDescriptor getAttributeDescriptor(String attributeName);
}
