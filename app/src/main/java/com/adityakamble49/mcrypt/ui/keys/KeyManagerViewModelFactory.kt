package com.adityakamble49.mcrypt.ui.keys

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.adityakamble49.mcrypt.cache.db.RSAKeyPairRepo
import com.adityakamble49.mcrypt.interactor.BuildRSAKeyPairUseCase
import com.adityakamble49.mcrypt.interactor.DeleteRSAKeyPairUseCase
import com.adityakamble49.mcrypt.interactor.SaveRSAKeyPairToFileUseCase
import com.adityakamble49.mcrypt.interactor.SaveRSAKeyPairUseCase

/**
 * KeyManager ViewModel Factory
 *
 * @author Aditya Kamble
 * @since 13/12/2017
 */
class KeyManagerViewModelFactory(
        private val rsaKeyPairRepo: RSAKeyPairRepo,
        private val buildRSAKeyPairUseCase: BuildRSAKeyPairUseCase,
        private val saveRSAKeyPairUseCase: SaveRSAKeyPairUseCase,
        private val saveRSAKeyPairToFileUseCase: SaveRSAKeyPairToFileUseCase,
        private val deleteRSAKeyPairUseCase: DeleteRSAKeyPairUseCase) :
        ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(KeyManagerViewModel::class.java)) {
            return KeyManagerViewModel(rsaKeyPairRepo, buildRSAKeyPairUseCase,
                    saveRSAKeyPairUseCase, saveRSAKeyPairToFileUseCase,
                    deleteRSAKeyPairUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}