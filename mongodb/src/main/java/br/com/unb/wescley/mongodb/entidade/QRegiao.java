package br.com.unb.wescley.mongodb.entidade;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;


/**
 * QRegiao is a Querydsl query type for Regiao
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRegiao extends EntityPathBase<Regiao> {

    private static final long serialVersionUID = -495757891L;

    public static final QRegiao regiao = new QRegiao("regiao");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nome = createString("nome");

    public final StringPath sigla = createString("sigla");

    public QRegiao(String variable) {
        super(Regiao.class, forVariable(variable));
    }

    public QRegiao(Path<? extends Regiao> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRegiao(PathMetadata metadata) {
        super(Regiao.class, metadata);
    }

}

