package br.com.unb.wescley.mongodb.entidade;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUnidadeFederacao is a Querydsl query type for UnidadeFederacao
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUnidadeFederacao extends EntityPathBase<UnidadeFederacao> {

    private static final long serialVersionUID = 1374519982L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUnidadeFederacao unidadeFederacao = new QUnidadeFederacao("unidadeFederacao");

    public final StringPath codigoIBGE = createString("codigoIBGE");

    public final StringPath nome = createString("nome");

    public final QRegiao regiao;

    public final StringPath sigla = createString("sigla");

    public QUnidadeFederacao(String variable) {
        this(UnidadeFederacao.class, forVariable(variable), INITS);
    }

    public QUnidadeFederacao(Path<? extends UnidadeFederacao> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUnidadeFederacao(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUnidadeFederacao(PathMetadata metadata, PathInits inits) {
        this(UnidadeFederacao.class, metadata, inits);
    }

    public QUnidadeFederacao(Class<? extends UnidadeFederacao> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.regiao = inits.isInitialized("regiao") ? new QRegiao(forProperty("regiao")) : null;
    }

}

