/*
 * Copyright (C) 2015-2016 The CyanogenMod Project
 * Copyright (C) 2017-2022 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lineageos.settings.device;

import android.os.Bundle;
import android.view.MenuItem;
import android.os.SystemProperties;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragment;

public class ActionsPreferenceFragment extends PreferenceFragment {

    private static final String KEY_ACTIONS_CATEGORY = "actions_key";

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.main_panel);

        try {
            if (!getResources().getBoolean(R.bool.config_rom_support_stylus)) {
                Preference pref = getPreferenceScreen().findPreference("stylus");
                if (pref != null) {
                    getPreferenceScreen().removePreference(pref);
                }
                Preference pref2 = getPreferenceScreen().findPreference("note");
                if (pref2 != null) {
                    getPreferenceScreen().removePreference(pref2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String deviceProp = SystemProperties.get("ro.product.product.device", "sofia");
            if (!deviceProp.contains("sofiap")) {
                Preference pref = getPreferenceScreen().findPreference("stylus");
                if (pref != null) {
                    getPreferenceScreen().removePreference(pref);
                }
                Preference pref2 = getPreferenceScreen().findPreference("note");
                if (pref2 != null) {
                    getPreferenceScreen().removePreference(pref2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getActivity().onBackPressed();
            return true;
        }
        return false;
    }
}