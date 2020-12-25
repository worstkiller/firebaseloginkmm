//
//  UIHostingController.swift
//  iosApp
//
//  Created by Vikas on 13/09/20.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation
import SwiftUI

/**
 a wrapper view for controlling the status bar scheme
 */
class UIHostingControllerApp<ContentView>: UIHostingController<ContentView> where ContentView: View {
    
    override dynamic open var preferredStatusBarStyle: UIStatusBarStyle {
        return .lightContent
    }
    
}
