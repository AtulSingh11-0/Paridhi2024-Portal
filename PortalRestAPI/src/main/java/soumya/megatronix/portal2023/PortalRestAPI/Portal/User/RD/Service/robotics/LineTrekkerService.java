package soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Service.robotics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.MRD.Model.MrdModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.MRD.Repository.MrdRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.gaming.BgmiLan;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.robotics.LineTrekkerModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Repository.robotics.LineTrekkerRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Verification.Email.Service.EmailService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class LineTrekkerService {
    @Autowired
    private LineTrekkerRepository robotics;

    @Autowired
    private MrdRepository repo;

    @Autowired
    private EmailService emailService;

    @Async
    public CompletableFuture<LineTrekkerModel> LineTrekkerRd(LineTrekkerModel member) {
        Optional<MrdModel> gid1 = repo.findByGid(member.getGid1());
        Optional<MrdModel> gid2 = Optional.ofNullable(member.getGid2()).flatMap(repo::findByGid);
        Optional<MrdModel> gid3 = Optional.ofNullable(member.getGid3()).flatMap(repo::findByGid);
        Optional<MrdModel> gid4 = Optional.ofNullable(member.getGid4()).flatMap(repo::findByGid);
        Optional<MrdModel> gid5 = Optional.ofNullable(member.getGid5()).flatMap(repo::findByGid);
        if ( gid1.isPresent() &&
                (gid2.isPresent() || member.getGid2() == null )&&
                (gid3.isPresent() || member.getGid3() == null)  &&
                (gid4.isPresent() || member.getGid4() == null)  &&
                (gid5.isPresent() || member.getGid5() == null)
        ) {
            List<LineTrekkerModel> list = robotics.findAll();
            for (LineTrekkerModel i : list) {
                if (
                        (
                                member.getGid1().equals(i.getGid1()) ||
                                        member.getGid1().equals(i.getGid2()) ||
                                        member.getGid1().equals(i.getGid3()) ||
                                        member.getGid1().equals(i.getGid4()) ||
                                        member.getGid1().equals(i.getGid5()) ||

                                        member.getGid1().equals(member.getGid2())||
                                        member.getGid1().equals(member.getGid3())||
                                        member.getGid1().equals(member.getGid4())||
                                        member.getGid1().equals(member.getGid5())
                        )||
                                (
                                        (member.getGid2() != null &&member.getGid2().equals(i.getGid1())) ||
                                                (member.getGid2() != null &&member.getGid2().equals(i.getGid2()) )||
                                                (member.getGid2() != null &&member.getGid2().equals(i.getGid3())) ||
                                                (member.getGid2() != null &&member.getGid2().equals(i.getGid4()) )||
                                                (member.getGid2() != null &&member.getGid2().equals(i.getGid5())) ||

                                                (member.getGid2() != null &&member.getGid2().equals(member.getGid1()))||
                                                (member.getGid2() != null &&member.getGid2().equals(member.getGid3()))||
                                                (member.getGid2() != null &&member.getGid2().equals(member.getGid4()))||
                                                (member.getGid2() != null &&member.getGid2().equals(member.getGid5()))
                                )||

                                (
                                        (
                                                (member.getGid3() != null && member.getGid3().equals(i.getGid3())) ||
                                                        (member.getGid3() != null &&member.getGid3().equals(i.getGid1())) ||
                                                        (member.getGid3() != null &&member.getGid3().equals(i.getGid2()) )||
                                                        (member.getGid3() != null &&member.getGid3().equals(i.getGid4())) ||
                                                        (member.getGid3() != null &&member.getGid3().equals(i.getGid5()))) ||

                                                (member.getGid3() != null &&member.getGid3().equals(member.getGid1()))||
                                                (member.getGid3() != null &&member.getGid3().equals(member.getGid2()))||
                                                (member.getGid3() != null &&member.getGid3().equals(member.getGid4()))||
                                                (member.getGid3() != null &&member.getGid3().equals(member.getGid5())
                                                )
                                )||

                                (
                                        (
                                                (member.getGid4() != null && member.getGid4().equals(i.getGid3())) ||
                                                        (member.getGid4() != null && member.getGid4().equals(i.getGid1()) )||
                                                        (member.getGid4() != null && member.getGid4().equals(i.getGid2())) ||
                                                        (member.getGid4() != null && member.getGid4().equals(i.getGid4())) ||
                                                        (member.getGid4() != null && member.getGid4().equals(i.getGid5()) )||

                                                        ( member.getGid4() != null && member.getGid4().equals(member.getGid1()))||
                                                        (member.getGid4() != null && member.getGid4().equals(member.getGid2()))||
                                                        (member.getGid4() != null && member.getGid4().equals(member.getGid3()))||
                                                        (member.getGid4() != null && member.getGid4().equals(member.getGid5()))
                                        )
                                )||

                                (
                                        (
                                                (member.getGid5() != null && member.getGid5().equals(i.getGid3())) ||
                                                        (member.getGid5() != null && member.getGid5().equals(i.getGid1())) ||
                                                        (member.getGid5() != null && member.getGid5().equals(i.getGid2())) ||
                                                        (member.getGid5() != null && member.getGid5().equals(i.getGid4())) ||
                                                        (member.getGid5() != null && member.getGid5().equals(i.getGid5()))||

                                                        (member.getGid5() != null && member.getGid5().equals(member.getGid1()))||
                                                        (member.getGid5() != null && member.getGid5().equals(member.getGid2()))||
                                                        (member.getGid5() != null && member.getGid5().equals(member.getGid3()))||
                                                        (member.getGid5() != null && member.getGid5().equals(member.getGid4()))
                                        )
                                )
                ) {
                    throw new RuntimeException("GID already exists.");
                }
            }
            if(
                    (
                            member.getGid1().equals(member.getGid2())||
                                    member.getGid1().equals(member.getGid3())||
                                    member.getGid1().equals(member.getGid4())||
                                    member.getGid1().equals(member.getGid5())
                    )||
                            (
                                    (member.getGid2() != null &&member.getGid2().equals(member.getGid1()))||
                                            (member.getGid2() != null &&member.getGid2().equals(member.getGid3()))||
                                            (member.getGid2() != null &&member.getGid2().equals(member.getGid4()))||
                                            (member.getGid2() != null &&member.getGid2().equals(member.getGid5()))
                            )||
                            (
                                    (member.getGid3() != null &&member.getGid3().equals(member.getGid2()))||
                                            (member.getGid3() != null &&member.getGid3().equals(member.getGid1()))||
                                            (member.getGid3() != null &&member.getGid3().equals(member.getGid4()))||
                                            (member.getGid3() != null &&member.getGid3().equals(member.getGid5()))
                            )||
                            (
                                    (member.getGid4() != null && member.getGid4().equals(member.getGid2()))||
                                            (member.getGid4() != null && member.getGid4().equals(member.getGid1()))||
                                            (member.getGid4() != null && member.getGid4().equals(member.getGid3()))||
                                            (member.getGid4() != null && member.getGid4().equals(member.getGid5()))
                            )
            )
                throw new RuntimeException("GID already exists");
            else {
                CompletableFuture<LineTrekkerModel> lineTrekker = CompletableFuture.completedFuture(robotics.save(member));
                member.setTid("paridhi"+member.getId()+"2002"+member.getId()+"05202024");
                robotics.save(member);
                sendEmail(member.getTid(), member.getTeamname());
                return lineTrekker;
            }
        }
        throw new RuntimeException("GID not present");
    }

    public CompletableFuture<MrdModel> checkGid(String gid) {
        MrdModel LineTrekker = repo.getModelByGid(gid);
        if (LineTrekker != null) {
            for (LineTrekkerModel i : robotics.findAll()) {
                if (
                        LineTrekker.getGid().equals(i.getGid1()) ||
                                LineTrekker.getGid().equals(i.getGid2()) ||
                                LineTrekker.getGid().equals(i.getGid3()) ||
                                LineTrekker.getGid().equals(i.getGid4()) ||
                                LineTrekker.getGid().equals(i.getGid5())
                ) {
                    throw new RuntimeException("GID already exists.");
                }
            }

            return CompletableFuture.completedFuture(LineTrekker);
        } else {
            throw new RuntimeException("GID not present");
        }
    }

    public Optional<LineTrekkerModel> findByGid (String gid) {
        Optional<LineTrekkerModel> gid1 = robotics.findByGid1(gid);
        Optional<LineTrekkerModel> gid2 = robotics.findByGid2(gid);
        Optional<LineTrekkerModel> gid3 = robotics.findByGid3(gid);
        Optional<LineTrekkerModel> gid4 = robotics.findByGid4(gid);
        Optional<LineTrekkerModel> gid5 = robotics.findByGid5(gid);

        if(gid1.isPresent() && !gid2.isPresent() && !gid3.isPresent() && !gid4.isPresent() && !gid5.isPresent()) {
            return gid1;
        } else if(!gid1.isPresent() && gid2.isPresent() && !gid3.isPresent() && !gid4.isPresent() && !gid5.isPresent()) {
            return gid2;
        } else if(!gid1.isPresent() && !gid2.isPresent() && gid3.isPresent() && !gid4.isPresent() && !gid5.isPresent()) {
            return gid3;
        } else if(!gid1.isPresent() && !gid2.isPresent() && !gid3.isPresent() && gid4.isPresent() && !gid5.isPresent()) {
            return gid4;
        } else if(!gid1.isPresent() && !gid2.isPresent() && !gid3.isPresent() && !gid4.isPresent() && gid5.isPresent()) {
            return gid5;
        } else {
            return Optional.empty();
        }
    }

    @Async
    protected void sendEmail(String tid, String teamName) {
        Optional<LineTrekkerModel> model = robotics.findByTid(tid);
        Optional<MrdModel> user1 = repo.findByGid(model.get().getGid1());
        Optional<MrdModel> user2 = repo.findByGid(model.get().getGid2());
        Optional<MrdModel> user3 = repo.findByGid(model.get().getGid3());
        Optional<MrdModel> user4 = repo.findByGid(model.get().getGid4());
        Optional<MrdModel> user5 = repo.findByGid(model.get().getGid5());
        List<String> emails = new ArrayList<>();
        if (user1.isPresent() && user1.get().getEmail() != null && !user1.get().getEmail().isEmpty()) {
            emails.add(user1.get().getEmail());
        }
        if (user2.isPresent() && user2.get().getEmail() != null && !user2.get().getEmail().isEmpty()) {
            emails.add(user2.get().getEmail());
        }
        if (user3.isPresent() && user3.get().getEmail() != null && !user3.get().getEmail().isEmpty()) {
            emails.add(user3.get().getEmail());
        }
        if (user4.isPresent() && user4.get().getEmail() != null && !user4.get().getEmail().isEmpty()) {
            emails.add(user4.get().getEmail());
        }
        if (user5.isPresent() && user5.get().getEmail() != null && !user5.get().getEmail().isEmpty()) {
            emails.add(user5.get().getEmail());
        }

        System.out.println(emails);
        emailService.sendEventRegistrationEmail(tid, "Line-Trekker", teamName, emails.toArray(new String[0]));
    }
}
