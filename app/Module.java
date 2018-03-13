import com.eduwin.services.impl.AboutUsServiceImpl;
import com.eduwin.services.impl.GalaryServiceImpl;
import com.eduwin.services.impl.LoginServiceImpl;
import com.eduwin.services.impl.MainServiceImpl;
import com.eduwin.services.impl.OpinionPollServiceImpl;
import com.google.inject.AbstractModule;
import com.tekizma.coreServices.CommonDao;
import com.tekizma.coreServices.CommonDaoImpl;
import com.tekizma.services.AboutUsService;
import com.tekizma.services.GalaryService;
import com.tekizma.services.LoginService;
import com.tekizma.services.MainService;
import com.tekizma.services.OpinionPollService;

/**
 * This class is a Guice module that tells Guice how to bind several
 * different types. This Guice module is created when the Play
 * application starts.
 *
 * Play will automatically use any class called `Module` that is in
 * the root package. You can create modules in other locations by
 * adding `play.modules.enabled` settings to the `application.conf`
 * configuration file.
 */
public class Module extends AbstractModule {

    @Override
    public void configure() {
        bind(MainService.class).to(MainServiceImpl.class);
        bind(LoginService.class).to(LoginServiceImpl.class);
        bind(AboutUsService.class).to(AboutUsServiceImpl.class);
        bind(CommonDao.class).to(CommonDaoImpl.class);
        bind(GalaryService.class).to(GalaryServiceImpl.class);
        bind(OpinionPollService.class).to(OpinionPollServiceImpl.class);
        
    }

}
