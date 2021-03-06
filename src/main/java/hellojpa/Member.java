package hellojpa;

import javax.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

//        @Column(name = "TEAM_ID")
//        private Long teamId;

    /**
     * ManyToOne(다 쪽이) 연관관계의 주인이 되는걸 약속하자 (DB의 테이블에서 N쪽인 것이 연관관계의 주인)
     */
    // OWNER (연관관계의 주인)
    // 객체의 Team객체와 DB의 TEAM_ID(PK)를 매핑
    @ManyToOne // Member 입장에서는 many이고 Team 입장에서는 One이기 때문에 ManyToOne
    // join을 해야 되는 컬럼이 뭐냐
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
