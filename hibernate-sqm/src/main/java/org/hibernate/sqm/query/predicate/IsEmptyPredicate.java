/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: Apache License, Version 2.0
 * See the LICENSE file in the root directory or visit http://www.apache.org/licenses/LICENSE-2.0
 */
package org.hibernate.sqm.query.predicate;

import org.hibernate.sqm.SemanticQueryWalker;
import org.hibernate.sqm.query.expression.Expression;

/**
 * @author Steve Ebersole
 */
public class IsEmptyPredicate implements Predicate {
	private final Expression expression;
	private boolean negated;

	public IsEmptyPredicate(Expression expression, boolean negated) {
		this.expression = expression;
		this.negated = negated;
	}

	public IsEmptyPredicate(Expression expression) {
		this( expression, false );
	}

	public Expression getExpression() {
		return expression;
	}

	public boolean isNegated() {
		return negated;
	}

	@Override
	public <T> T accept(SemanticQueryWalker<T> walker) {
		return walker.visitIsEmptyPredicate( this );
	}
}
