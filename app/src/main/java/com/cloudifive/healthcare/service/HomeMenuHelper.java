package com.cloudifive.healthcare.service;

import android.app.ProgressDialog;
import android.content.Context;

import com.cloudifive.healthcare.definitions.IAllMenuCategory;
import com.cloudifive.healthcare.helpers.MenuCategoryHelper;

import org.json.JSONObject;

import bolts.Continuation;
import bolts.Task;

/**
 * Created by karthik.r on 29/05/2018.
 */

public enum HomeMenuHelper implements IAllMenuCategory {
    INSTANCE {

        private MenuCategoryHelper menuCategoryHelper = new MenuCategoryHelper();
        ProgressDialog progressDialog;
        private ProgressDialog pDialog;
        Context context;

        public void setProgressDialog(ProgressDialog progressDialog) {
            this.progressDialog = progressDialog;
            progressDialog.setCancelable(true);
        }


        public void setContext(Context context) {
            this.context = context;

        }


        private void showProgressDialog() {
            try {
                progressDialog = ProgressDialog.show(context, "", "Loading", true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void dismissDialog() {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }

        @Override
        public Task<JSONObject> getDoctors() {
            // showProgressDialog();
            return menuCategoryHelper.getDoctors().continueWith(new Continuation<JSONObject, JSONObject>() {
                @Override
                public JSONObject then(Task<JSONObject> task) throws Exception {
                    final JSONObject jsonObject = task.getResult();
                    //dismissDialog();
                    return jsonObject;
                }
            });

        }
        @Override
        public Task<JSONObject> getSucessStory() {
            // showProgressDialog();
            return menuCategoryHelper.getSucessStory().continueWith(new Continuation<JSONObject, JSONObject>() {
                @Override
                public JSONObject then(Task<JSONObject> task) throws Exception {
                    final JSONObject jsonObject = task.getResult();
                    //dismissDialog();
                    return jsonObject;
                }
            });

        }

        @Override
        public Task<JSONObject> getChairmanMessage() {
            return menuCategoryHelper.getChairmanMessage().continueWith(new Continuation<JSONObject, JSONObject>() {
                @Override
                public JSONObject then(Task<JSONObject> task) throws Exception {
                    final JSONObject jsonObject = task.getResult();
                    //dismissDialog();
                    return jsonObject;
                }
            });
        }



        @Override
        public Task<JSONObject> getFacilities() {

            return menuCategoryHelper.getFacilities().continueWith(new Continuation<JSONObject, JSONObject>() {
                @Override
                public JSONObject then(Task<JSONObject> task) throws Exception {
                    final JSONObject jsonObject = task.getResult();
//                    dismissDialog();
                    return jsonObject;
                }
            });

        }

        @Override
        public Task<JSONObject> getOffers() {
            return menuCategoryHelper.getOffers().continueWith(new Continuation<JSONObject, JSONObject>() {
                @Override
                public JSONObject then(Task<JSONObject> task) throws Exception {
                    final JSONObject jsonObject = task.getResult();
                    //dismissDialog();
                    return jsonObject;
                }
            });
        }
        @Override
        public Task<JSONObject> getInfra() {
            return menuCategoryHelper.getInfra().continueWith(new Continuation<JSONObject, JSONObject>() {
                @Override
                public JSONObject then(Task<JSONObject> task) throws Exception {
                    final JSONObject jsonObject = task.getResult();
                    //dismissDialog();
                    return jsonObject;
                }
            });
        }

        @Override
        public Task<JSONObject> getDepartments() {
            return menuCategoryHelper.getDepartments().continueWith(new Continuation<JSONObject, JSONObject>() {
                @Override
                public JSONObject then(Task<JSONObject> task) throws Exception {
                    final JSONObject jsonObject = task.getResult();
                    //dismissDialog();
                    return jsonObject;
                }
            });
        }

        @Override
        public Task<JSONObject> getContactus() {
            return menuCategoryHelper.getContactus().continueWith(new Continuation<JSONObject, JSONObject>() {
                @Override
                public JSONObject then(Task<JSONObject> task) throws Exception {
                    final JSONObject jsonObject = task.getResult();
                    //dismissDialog();
                    return jsonObject;
                }
            });
        }

        @Override
        public Task<JSONObject> doFeedback(String name, String phone, String email, String subject, String comments) {
            return menuCategoryHelper.doFeedback(name,phone,email,subject,comments).continueWith(new Continuation<JSONObject, JSONObject>() {
                @Override
                public JSONObject then(Task<JSONObject> task) throws Exception {
                    final JSONObject jsonObject=task.getResult();
                    dismissDialog();
                    return jsonObject;
                }
            });
        }

        @Override
        public Task<JSONObject> getAboutus() {
            return menuCategoryHelper.getAboutus().continueWith(new Continuation<JSONObject, JSONObject>() {
                @Override
                public JSONObject then(Task<JSONObject> task) throws Exception {
                    final JSONObject jsonObject = task.getResult();
                    //dismissDialog();
                    return jsonObject;
                }
            });
        }


    }
}
