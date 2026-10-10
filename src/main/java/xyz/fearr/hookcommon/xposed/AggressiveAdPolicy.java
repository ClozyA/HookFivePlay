package xyz.fearr.hookcommon.xposed;

/** Ad SDK and Activity namespaces observed in the inspected 5E target APK. */
final class AggressiveAdPolicy {
    private static final String[] SDK_PREFIXES = {
            "com.bytedance.sdk.openadsdk.", "com.byazt.", "com.kwad.", "com.qq.e.",
            "com.baidu.mobads.", "com.beizi.", "biz.beizi.adn.", "com.bz.",
            "com.sy.adsdk.", "com.gt.sdk.", "xyz.adscope.amps.", "com.kc.",
            "com.octopus.ad.", "com.qumeng.advlib.", "com.sigmob.sdk.",
            "com.meishu.sdk.", "com.mercury.sdk.", "cj.mobile.", "com.fancy.mpsdk.",
            "com.fiveplay.commonlibrary.view.ad."
    };

    static boolean sdkClass(String name) {
        if (name == null) return false;
        for (String prefix : SDK_PREFIXES) if (name.startsWith(prefix)) return true;
        return false;
    }

    static boolean adActivity(String name) {
        return sdkClass(name)
                || "com.fiveplay.sihp_homepage.module.splash.RewardVideoActivity".equals(name);
    }

    private AggressiveAdPolicy() {
    }
}
