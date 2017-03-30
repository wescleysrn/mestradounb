package br.com.unb.wescley.mongodb.entidade;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMunicipio is a Querydsl query type for Municipio
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMunicipio extends EntityPathBase<Municipio> {

    private static final long serialVersionUID = 1456069939L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMunicipio municipio = new QMunicipio("municipio");

    public final StringPath codigoIBGE = createString("codigoIBGE");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMicroRegiao microRegiao;

    public final StringPath nome = createString("nome");

    public final QUnidadeFederacao uf;

    public QMunicipio(String variable) {
        this(Municipio.class, forVariable(variable), INITS);
    }

    public QMunicipio(Path<? extends Municipio> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMunicipio(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMunicipio(PathMetadata metadata, PathInits inits) {
        this(Municipio.class, metadata, inits);
    }

    public QMunicipio(Class<? extends Municipio> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.microRegiao = inits.isInitialized("microRegiao") ? new QMicroRegiao(forProperty("microRegiao"), inits.get("microRegiao")) : null;
        this.uf = inits.isInitialized("uf") ? new QUnidadeFederacao(forProperty("uf"), inits.get("uf")) : null;
    }

}

