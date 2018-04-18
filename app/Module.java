import com.eduwin.coreServices.CommonDao;
import com.eduwin.coreServices.CommonDaoImpl;
import com.eduwin.services.AboutUsService;
import com.eduwin.services.GalaryService;
import com.eduwin.services.LoginService;
import com.eduwin.services.OpinionPollService;
import com.eduwin.services.impl.AboutUsServiceImpl;
import com.eduwin.services.impl.GalaryServiceImpl;
import com.eduwin.services.impl.LoginServiceImpl;
import com.eduwin.services.impl.OpinionPollServiceImpl;
import com.google.inject.AbstractModule;

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
        bind(LoginService.class).to(LoginServiceImpl.class);
        bind(AboutUsService.class).to(AboutUsServiceImpl.class);
        bind(CommonDao.class).to(CommonDaoImpl.class);
        bind(GalaryService.class).to(GalaryServiceImpl.class);
        bind(OpinionPollService.class).to(OpinionPollServiceImpl.class);    
    }

}
