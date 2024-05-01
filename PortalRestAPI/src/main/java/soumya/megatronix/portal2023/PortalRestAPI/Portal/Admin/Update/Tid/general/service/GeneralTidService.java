package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Update.Tid.general.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.general.BingeQuiz;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.general.Carrom;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.general.TableTennis;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Repository.general.BingeQuizRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Repository.general.CarromRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Repository.general.TableTennisRepository;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class GeneralTidService {

    @Autowired
    private BingeQuizRepository bingeQuizRepository;
    @Autowired
    private TableTennisRepository tableTennisRepository;

    @Autowired
    private CarromRepository carromRepository;

    @Async
    public CompletableFuture<BingeQuiz> updateBingeQuizPaidStatus (
            String tid,
            boolean paid
    ) {
        Optional<BingeQuiz> model = bingeQuizRepository.findByTid(tid);

        if(model.isEmpty())
            throw new RuntimeException("No such TID found");
        else {
            model.get().setPaid(paid);
            return CompletableFuture.completedFuture(bingeQuizRepository.save(model.get()));
        }
    }

    @Async
    public CompletableFuture<TableTennis> updateTableTennisPaidStatus (
            String tid,
            boolean paid
    ) {
        Optional<TableTennis> model = tableTennisRepository.findByTid(tid);

        if(model.isEmpty())
            throw new RuntimeException("No such TID found");
        else {
            model.get().setPaid(paid);
            return CompletableFuture.completedFuture(tableTennisRepository.save(model.get()));
        }
    }

    @Async
    public CompletableFuture<Carrom> updateCarromPaidStatus (
            String tid,
            boolean paid
    ) {
        Optional<Carrom> model = carromRepository.findByTid(tid);

        if(model.isEmpty())
            throw new RuntimeException("No such TID found");
        else {
            model.get().setPaid(paid);
            return CompletableFuture.completedFuture(carromRepository.save(model.get()));
        }
    }




}
