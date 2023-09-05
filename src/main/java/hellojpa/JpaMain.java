package hellojpa;


import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("city", "street", "10000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

//            member.getAddressHistory().add(new Address("old1", "street", "10000"));
//            member.getAddressHistory().add(new Address("old2", "street", "10000"));

            member.getAddressHistory().add(new AddressEntity("old1", "street", "10000"));
            member.getAddressHistory().add(new AddressEntity("old2", "street", "10000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("============START============");
            Member findMember = em.find(Member.class, member.getId());
/*
            //homeCity -> newCity
//            findMember.getHomeAddress().setCity("newCity");
            Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));

            //치킨 -> 한식
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");
*/
            //old1 -> new1, hashcode구성 중요
//            findMember.getAddressHistory().remove(new Address("old1", "street", "10000"));
//            findMember.getAddressHistory().add(new Address("new1", "street", "10000"));


/*
            List<Address> addressHistory = findMember.getAddressHistory();
            for (Address address : addressHistory) {
                System.out.println("address = " + address.getCity());
            }

            Set<String> favoriteFoods = findMember.getFavoriteFoods();
            for (String favoriteFood : favoriteFoods) {
                System.out.println("favoriteFood = " + favoriteFood);
            }
*/
/*
            Address address = new Address("city", "street", "10000");

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setHomeAddress(address);
            em.persist(member1);

            Address copyAddress = new Address(address.getCity(), address.getCity(), address.getStreet());

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setHomeAddress(address);
            em.persist(member2);

            member1.getHomeAddress().setCity("newCity");
*/

/*
            Member member = new Member();
            member.setUsername("hello");
            member.setHomeAddress(new Address("city", "street", "10000"));
            member.setWorkPeriod(new Period());

            em.persist(member);
*/
/*
            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);
//            em.persist(child1);
//            em.persist(child2);

            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
            findParent.getChildList().remove(0);

//            em.remove(findParent);
*/
/*
            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            em.flush();
            em.clear();

            List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();

            //SQL : select * from Member
            //SQL : select * from Team where TEAM_ID = xxx
*/
/*
            Member m = em.find(Member.class, member1.getId());
            System.out.println("m = " + m.getId().getClass());

            System.out.println("========================");
            m.getTeam().getName(); //초기화
            System.out.println("========================");
*/

/*
            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember = " + refMember.getClass()); //Proxy
//            refMember.getUsername();
            Hibernate.initialize(refMember); //강제 초기화
//            System.out.println("isoLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));

//            em.detach(refMember);
//            em.close();
//            em.clear();

//            System.out.println("refMember = " + refMember.getUsername());

//            refMember.getUsername();
*/
/*
            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember = " + refMember.getClass()); //Proxy

            Member findMember = em.find(Member.class, member1.getId());
            System.out.println("findMember = " + findMember.getClass()); //Member

            System.out.println("refMember == findMember = " + (refMember == findMember));
*/
/*
            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            em.flush();
            em.clear();

            Member m1 = em.find(Member.class, member1.getId());
            System.out.println("m1. = " + m1.getClass());

            Member reference = em.getReference(Member.class, member1.getId());
            System.out.println("reference = " + reference.getClass());

            System.out.println("a == a:" + (m1 == reference));
*/

/*
            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            em.persist(member2);

            em.flush();
            em.clear();

            Member m1 = em.find(Member.class, member1.getId());
            Member m2 = em.find(Member.class, member2.getId());

            logic(m1, m2);
*/
/*
//            Member findMember = em.find(Member.class, member.getId());
            Member findMember = em.getReference(Member.class, member.getId());
            System.out.println("findMember = " + findMember.getClass());
            System.out.println("findMember = " + findMember.getId());
            System.out.println("findMember = " + findMember.getUsername());
*/
/*
            Member member = em.find(Member.class, 1L);
            printMember(member);
            printMemberAndTeam(member);
*/
/*
            Movie movie = new Movie();
            movie.setDirector("aaa");
            movie.setActor("bbb");
            movie.setName("바람과함께");
            movie.setPrice(1000);

            em.persist(movie);

            em.flush();
            em.clear();

            Movie findMove = em.find(Movie.class, movie.getId());
            System.out.println("findMove = " + findMove);

 */
/*
            Member member1 = new Member();
            member1.setUsername("A");

            Member member2 = new Member();
            member2.setUsername("B");

            Member member3 = new Member();
            member3.setUsername("C");

            System.out.println("========================");

            em.persist(member1); // 1, 51

 */
//            em.persist(member2); //MEMORY
//            em.persist(member3); //MEMORY


/*
            //영속
            Member member = new Member();
            member.setId(3L);
            member.setUsername("C");
            member.setRoleType(RoleType.GUEST);

            em.persist(member);
*/
/*
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZ");
            System.out.println("========================");
*/
/*
            //영속
            Member member1 = new Member(150L,"A");
            Member member2 = new Member(160L,"B");

            em.persist(member1);
            em.persist(member2);

            System.out.println("========================");
*/
/*
            //영속
            Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);

            System.out.println("resule : " + (findMember1==findMember2));
*/
/*
            //비영속
            Member member1 = new Member();
            member1.setId(10L);
            member1.setName("HelloJPA");
            //영속
            System.out.println("JpaMain.main before");
            em.persist(member1);
            System.out.println("JpaMain.main after");

            Member findMember = em.find(Member.class, 101L);

            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());
*/
/*
//            Member findMember = em.find(Member.class, 1L);
            //JPQL
            List<Member> result = em.createQuery("select m from Member m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();
            for (Member member : result) {
                System.out.println("member = " + member.getName());
            }
*/
/*
            //수정
            findMember.setName("HelloJPA");
            //삭제
            em.refresh(findMember);

            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");

            em.persist(member);
*/
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
/*
    private static void logic(Member m1, Member m2) {
//        System.out.println("m1 == m2" + (m1.getClass() == m2.getClass()));
        System.out.println("m1 == m2" + (m1 instanceof Member));
        System.out.println("m1 == m2" + (m2 instanceof Member));
    }
 */
/*
    private static void printMember(Member member) {
        System.out.println("member. = " + member.getUsername());
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println("username = " + username);

        Team team = member.getTeam();
        System.out.println("team = " + team.getName());
    }
 */
}
