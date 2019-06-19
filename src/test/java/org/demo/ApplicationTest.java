package org.demo;

import static org.mockito.Mockito.never;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Unit test for simple Application.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Launcher.class, Application.class})
public class ApplicationTest

{
    @Test
    public void shouldReturnResult() throws Exception {
        String[] args = new String[]{"test", "test doc1", "test doc2"};
        Launcher launcher = PowerMockito.mock(Launcher.class);
        PowerMockito.whenNew(Launcher.class).withNoArguments().thenReturn(launcher);
        Application.main(args);
        PowerMockito.verifyNew(Launcher.class).withNoArguments();
        Mockito.verify(launcher).run(args);
    }

    @Test
    public void shouldNotCallLauncher() throws Exception {
        String[] args = new String[]{};
        Launcher launcher = PowerMockito.mock(Launcher.class);
        PowerMockito.whenNew(Launcher.class).withNoArguments().thenReturn(launcher);
        Application.main(args);
        PowerMockito.verifyNew(Launcher.class, never()).withNoArguments();
        Mockito.verify(launcher, never()).run(args);
    }
}
