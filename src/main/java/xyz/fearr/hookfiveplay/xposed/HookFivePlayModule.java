package xyz.fearr.hookfiveplay.xposed;

import xyz.fearr.hookcommon.xposed.AggressiveAdRules;
import xyz.fearr.hookcommon.xposed.TargetHookModule;

public final class HookFivePlayModule extends TargetHookModule {
    private static final String PACKAGE_NAME = "com.fiveplay";

    @Override
    protected String targetPackage() {
        return PACKAGE_NAME;
    }

    @Override
    protected String moduleTag() {
        return "HookFivePlay";
    }

    @Override
    protected String[] classLoaderProbeClasses() {
        return new String[]{
                "com.fiveplay.commonlibrary.utils.AdUtils",
                "com.fiveplay.commonlibrary.view.ad.AdNativeView",
                "com.fiveplay.reward.service.AdFlowServiceImpl"};
    }

    @Override
    protected void installTargetRules(ClassLoader loader) {
        new FivePlayRules(this).install(loader);
        new AggressiveAdRules(this, PACKAGE_NAME).install(loader);
    }
}
