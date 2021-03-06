/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: Apache License, Version 2.0
 * See the LICENSE file in the root directory or visit http://www.apache.org/licenses/LICENSE-2.0
 */
package org.hibernate.sqm.query.expression;

import org.hibernate.sqm.SemanticQueryWalker;
import org.hibernate.sqm.domain.CollectionTypeDescriptor;
import org.hibernate.sqm.domain.TypeDescriptor;
import org.hibernate.sqm.path.AttributePathPart;
import org.hibernate.sqm.query.from.FromElement;

/**
 * @author Steve Ebersole
 */
public class IndexedAttributePathPart implements AttributePathPart, Expression {
	private final AttributePathPart source;
	private final Expression index;

	private final TypeDescriptor typeDescriptor;

	public IndexedAttributePathPart(AttributePathPart source, Expression index) {
		this.source = source;
		this.index = index;

		// Ultimately the TypeDescriptor for this part is the same as the elements of the collection...
		this.typeDescriptor = ( (CollectionTypeDescriptor) source.getTypeDescriptor() ).getElementTypeDescriptor();
	}

	public AttributePathPart getSource() {
		return source;
	}

	public Expression getIndex() {
		return index;
	}

	@Override
	public TypeDescriptor getTypeDescriptor() {
		return typeDescriptor;
	}

	@Override
	public FromElement getUnderlyingFromElement() {
		// todo : almost positive this is not accurate in most cases
		return source.getUnderlyingFromElement();
	}

	@Override
	public <T> T accept(SemanticQueryWalker<T> walker) {
		throw new UnsupportedOperationException( "see todo comment" );
	}
}
