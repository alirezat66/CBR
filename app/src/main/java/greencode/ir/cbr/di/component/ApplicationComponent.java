package greencode.ir.cbr.di.component;

import javax.inject.Singleton;

import dagger.Component;
import greencode.ir.cbr.di.madoul.ApplicationModule;

@Component (modules = ApplicationModule.class)
@Singleton
public interface ApplicationComponent {

}
