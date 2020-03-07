package br.com.jugpe.resources;

import br.com.jugpe.models.Member;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/members")@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MembersResource {


    @GET
    public Collection<Member> findAll(){
        return Member.findAll().list();
    }

    @Transactional
    @POST
    public Member add(Member member){
        member.persist();
        return member;
    }

}
