package br.com.unb.wescley.mongodb.entidade;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMesoRegiao is a Querydsl query type for MesoRegiao
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMesoRegiao extends EntityPathBase<MesoRegiao> {

    private static final long serialVersionUID = 1706509265L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMesoRegiao mesoRegiao = new QMesoRegiao("mesoRegiao");

    public final StringPath codigoIBGE = createString("codigoIBGE");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nome = createString("nome");

    public final QUnidadeFederacao uf;

    public QMesoRegiao(String variable) {
        this(MesoRegiao.class, forVariable(variable), INITS);
    }

    public QMesoRegiao(Path<? extends MesoRegiao> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMesoRegiao(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMesoRegiao(PathMetadata metadata, PathInits inits) {
        this(MesoRegiao.class, metadata, inits);
    }

    public QMesoRegiao(Class<? extends MesoRegiao> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.uf = inits.isInitialized("uf") ? new QUnidadeFederacao(forProperty("uf"), inits.get("uf")) : null;
    }

}

