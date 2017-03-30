package br.com.unb.wescley.mongodb.entidade;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMicroRegiao is a Querydsl query type for MicroRegiao
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMicroRegiao extends EntityPathBase<MicroRegiao> {

    private static final long serialVersionUID = -213960467L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMicroRegiao microRegiao = new QMicroRegiao("microRegiao");

    public final StringPath codigoIBGE = createString("codigoIBGE");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMesoRegiao mesoRegiao;

    public final StringPath nome = createString("nome");

    public QMicroRegiao(String variable) {
        this(MicroRegiao.class, forVariable(variable), INITS);
    }

    public QMicroRegiao(Path<? extends MicroRegiao> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMicroRegiao(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMicroRegiao(PathMetadata metadata, PathInits inits) {
        this(MicroRegiao.class, metadata, inits);
    }

    public QMicroRegiao(Class<? extends MicroRegiao> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mesoRegiao = inits.isInitialized("mesoRegiao") ? new QMesoRegiao(forProperty("mesoRegiao"), inits.get("mesoRegiao")) : null;
    }

}

