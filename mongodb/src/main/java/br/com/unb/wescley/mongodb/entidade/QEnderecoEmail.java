package br.com.unb.wescley.mongodb.entidade;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEnderecoEmail is a Querydsl query type for EnderecoEmail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEnderecoEmail extends EntityPathBase<EnderecoEmail> {

    private static final long serialVersionUID = 340171673L;

    public static final QEnderecoEmail enderecoEmail = new QEnderecoEmail("enderecoEmail");

    public final StringPath id = createString("id");

    public final StringPath value = createString("value");

    public QEnderecoEmail(String variable) {
        super(EnderecoEmail.class, forVariable(variable));
    }

    public QEnderecoEmail(Path<? extends EnderecoEmail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEnderecoEmail(PathMetadata metadata) {
        super(EnderecoEmail.class, metadata);
    }

}

